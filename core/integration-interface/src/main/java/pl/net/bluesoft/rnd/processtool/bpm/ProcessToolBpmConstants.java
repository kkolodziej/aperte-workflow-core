package pl.net.bluesoft.rnd.processtool.bpm;


public interface ProcessToolBpmConstants 
{
    String PRIVILEGE_INCLUDE = "INCLUDE";
    String PRIVILEGE_EXCLUDE = "EXCLUDE";
    String PRIVILEGE_EDIT = "EDIT";
    String PRIVILEGE_VIEW = "VIEW";

    String PATTERN_MATCH_ALL = ".*";

    String REQUEST_PARAMETER_TASK_ID = "bpmTaskId";
    
    /** Token ID for external access */
    String REQUEST_PARAMETER_TOKEN_ID = "tokenId";
    
    /** Portlet specified css styles */
    String APERTEWORKFLOW_CSS_PATH = "VAADIN/themes/aperteworkflow/styles.css";
    
    String TOKEN_SERVLET_URL = "/osgiex/token_access";
    
	/** Text mode request parameter. If it is set to true, no html will be generated */
	String TEXT_MODE = "textMode";
	
	/** Text modes enumeration type */
	public static enum 			TextModes 
	{ 
		PLAIN("text/plain; charset=UTF-8"), 
		HTML("text/html; charset=UTF-8"), 
		JSON("application/json");
		
		private String type;
		
		private TextModes(String type)
		{
			this.type = type;
		}
		
		public String getMode()
		{
			return type;
		}
		
		public static TextModes getTextModeType(String name)
		{
			if(name == null)
				return null;
			
			for(TextModes mode: TextModes.values())
				if(name.equals(mode.toString()))
					return mode;
			
			return null;
		}
	};
}
