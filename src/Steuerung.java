/**
 * Write a description of class Steuerung here.
 * 
 * @author Jan Hofmeier
 * @version 20131128
 */
public class Steuerung
{
	// instance variables - replace the example below with your own#

	private GUI dieGUI;
	private FlugBuchung[] dieFlugBuchung=new FlugBuchung[10000];
	private Passagier[] derPassagier = new Passagier[10000];
	private int aAnzahlBuchung=0; // int weil GZ
	private int aAnzahlPassagiere=0; // int weil GZ
	private String aEntfernung[][] = { { "Berlin", "100" },
			{ "New York", "5000" } }; // string weil da ein text ist

	/**
	 * Constructor for objects of class Steuerung
	 */
	public Steuerung()
	{
		dieGUI = new GUI(this);
		//derPassagier[1230] = new Passagier("Maier", "Hans"); // zum test
	}

	public void neueBuchung(String pName, String pVName, String pDatum,
			String pReiseziel)
	{
		for(int i=0; i<derPassagier.length;i++)
		{
			if(derPassagier[i]!=null)
			{
				if (pName.equals(derPassagier[i].gibName())
						&& pVName.equals(derPassagier[i].gibVorname()))
				{
					dieFlugBuchung[aAnzahlBuchung++]=new FlugBuchung(i,pDatum,pReiseziel);
					return;
				}
			}
		}
	}

	public boolean storniereBuchung(int pPassNr, String pDatum)
	{
		return false;
	}

	public void neuerPassagier(String pName, String pVorname)
	{
		derPassagier[aAnzahlPassagiere++] = new Passagier(pName, pVorname);
	}

	public void gutschreibenMeilen(int pPassNr, String pZiel)
	{
		int entfernung = ermittleEntfernung(pZiel);
		if (entfernung < 0)
		{
			System.out.println("Ziel nicht gefunden");
		} else
		{
			derPassagier[pPassNr].gutschreibenMeilen(entfernung);
			String status = derPassagier[pPassNr].gibStatus();
			String name = derPassagier[pPassNr].gibName();
			String vName = derPassagier[pPassNr].gibVorname();
			dieGUI.anzeigenText("Status fuer" + vName + " " + name, status);
		}
	}

	private int ermittleEntfernung(String pZiel)
	{
		for (String[] s : aEntfernung)
		{
			if (s[0].equals(pZiel))
			{
				return Integer.parseInt(s[1]);
			}
		}

		return -1;
	}

	public void anzeigeReiseziel(String pName, String pVName, String pDatum)
	{
		boolean pGefunden = false;
		boolean zGefunden = false;
		String dasReiseziel="------";
		for (int i = 0; i < derPassagier.length && !pGefunden; i++)
		{
			if (derPassagier[i] != null)
			{
				if (pName.equals(derPassagier[i].gibName())
						&& pVName.equals(derPassagier[i].gibVorname()))
				{
					pGefunden = true;
					for (int j = 0; j < dieFlugBuchung.length && !zGefunden; j++)
					{
						if (dieFlugBuchung[j] != null)
						{
							if (i == dieFlugBuchung[j].gibPassagierNr()
									&& pDatum.equals(dieFlugBuchung[j]
											.gibDatum()))
							{
								zGefunden=true;
								dasReiseziel=dieFlugBuchung[j].gibReiseziel();
							}
						}
					}
				}

			}
		}
		dieGUI.anzeigenText("Reiseziel:", dasReiseziel);
	}
	
	public static void main(String[] args)
	{
		Steuerung s=new Steuerung();
		s.dieGUI.clickNeuerPassagier();
		s.dieGUI.clickNeueBuchung();
		s.dieGUI.clickAnzeigeReiseziel();
	}
		
	
}
