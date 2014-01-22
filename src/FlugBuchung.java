
/**
 * Write a description of class FlugBuchung here.
 * 
 * @author Jan Hofmeier
 * @version (a version number or a date)
 */
public class FlugBuchung
{
    // instance variables - replace the example below with your own
    
    private String aReiseziel;
    private String aDatum;
    private int aPassagierNr;
   
    public FlugBuchung(int pPassNr, String pDatum, String pReiseziel)
    {
        aPassagierNr=pPassNr;
        aReiseziel=pReiseziel;
        aDatum=new String(pDatum);
    }
    
    public String gibReiseziel()
    {
        return aReiseziel;
    }
    public String gibDatum()
    {
        return aDatum;
    }
    public int gibPassagierNr()
    {
        return aPassagierNr;
    }      
}
