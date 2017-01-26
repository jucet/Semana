package tools;

public class Parse {
	
	// For string parsing
	public static String GetContentBetweenAutomation(String strText, String fromText, String strStart, String strEnd, boolean isThisAfter, int number)
	{
		int nPos = 0, fromStart=0, nStart = 0, nEnd = 0;
		String strContent = "";

		if((fromStart = strText.indexOf(fromText, 0))!= -1)
		{
			fromStart += fromText.length();

			/////////////////////////////////////////////////
			// This added to make the automation part work //
			/////////////////////////////////////////////////
			for(int i=0;i<number-1;i++)
			{

				if(strText.indexOf(fromText,fromStart+1)!= -1){
					fromStart = strText.indexOf(fromText,fromStart+1);
				}
				else{
					return "NOTFOUND";
					// break;
				}
			}
			////////////////////////////////////////////////
			if(!isThisAfter)
			{
				if( (nStart = strText.indexOf(strStart, fromStart))!= -1 )
				{

					nStart += strStart.length();
					if((nEnd = strText.indexOf(strEnd, nStart)) != -1)
					{
						strContent = strText.substring(nStart, nEnd);
						return strContent;
					}
				}
			}
			else
			{
				if( (nStart = strText.indexOf(strStart, fromStart))!= -1 )
				{
					nStart += strStart.length();

					if((nEnd = strText.indexOf(strEnd, nStart)) != -1)
					{
						strContent = strText.substring(nStart, nEnd);
						return strContent;
					}
				}
			}

		}

		return "NOTFOUND";
	}

}
