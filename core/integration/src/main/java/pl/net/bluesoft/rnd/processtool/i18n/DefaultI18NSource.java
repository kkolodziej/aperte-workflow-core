package pl.net.bluesoft.rnd.processtool.i18n;

import pl.net.bluesoft.rnd.processtool.ProcessToolContext;
import pl.net.bluesoft.rnd.util.i18n.I18NProvider;
import pl.net.bluesoft.rnd.util.i18n.I18NSource;

import java.util.Collection;
import java.util.Locale;

/**
 * @author tlipski@bluesoft.net.pl
 */
public class DefaultI18NSource implements I18NSource {

	private Locale locale;


	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	@Override
	public String getMessage(String key) {
		return getMessage(key, key);
	}

	@Override
	public String getMessage(String key, String defaultValue) {
		Collection<I18NProvider> i18NProviders = ProcessToolContext.Util.getProcessToolContextFromThread().getRegistry().getI18NProviders();
		//1st run - full localization e.g. _pl_PL
		for (I18NProvider i18NProvider : i18NProviders) {
			if (!i18NProvider.hasFullyLocalizedMessage(key, locale)) continue;
			String m = i18NProvider.getMessage(key, locale);
			if (m != null) return m;
		}

		//2nd run - only country e.g. _pl
		for (I18NProvider i18NProvider : i18NProviders) {
			if (!i18NProvider.hasLocalizedMessage(key, locale)) continue;
			String m = i18NProvider.getMessage(key, locale);
			if (m != null) return m;
		}

		//3rd run - with default values
		for (I18NProvider i18NProvider : i18NProviders) {
			String m = i18NProvider.getMessage(key, locale);
			if (m != null) return m;
		}
		return defaultValue;
	}

    public String getMessage(String key, Collection<I18NProvider> i18NProviders) {
        return getMessage(key, key, i18NProviders);
    }

    public String getMessage(String key, String defaultValue, Collection<I18NProvider> i18NProviders) {
        if(i18NProviders == null || key == null)
            return defaultValue;
        //1st run - full localization e.g. _pl_PL
        for (I18NProvider i18NProvider : i18NProviders) {
            if (!i18NProvider.hasFullyLocalizedMessage(key, locale)) continue;
            String m = i18NProvider.getMessage(key, locale);
            if (m != null) return m;
        }

        //2nd run - only country e.g. _pl
        for (I18NProvider i18NProvider : i18NProviders) {
            if (!i18NProvider.hasLocalizedMessage(key, locale)) continue;
            String m = i18NProvider.getMessage(key, locale);
            if (m != null) return m;
        }

        //3rd run - with default values
        for (I18NProvider i18NProvider : i18NProviders) {
            String m = i18NProvider.getMessage(key, locale);
            if (m != null) return m;
        }
        return defaultValue;
    }
}
