
/**
 * Write a description of class Passagier here.
 * 
 * @author Jan Hofmeier
 * @version (a version number or a date)
 */
public class Passagier
{
    // instance variables - replace the example below with your own
    
    private MeilenKonto dasMeilenKonto;
    
    private String aName;
    private String aVorname;
    


    public Passagier(String pName, String pVorname)
    {
        this.aName=pName;
        this.aVorname=pVorname;
        dasMeilenKonto=new MeilenKonto();
    }


    public String gibStatus()
    {
        return "";
    }
    
    public void gutschreibenMeilen(int pEntfernung)
    {
        dasMeilenKonto.gutschreibenMeilen(pEntfernung);
    }
    
    public void verbraucheMeilen(int pEntfernung)
    {
    }
    
    public int gibFlugmeilen()
    {
        return 0;
    }
    
    public String gibName()
    {
        return aName;
    }
    
    public String gibVorname()
    {
        return aVorname;
    }
}
