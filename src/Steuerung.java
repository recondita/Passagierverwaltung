/**
 * Write a description of class Steuerung here.
 * 
 * @author Jan Hofmeier
 * @version 20131128
 */
public class Steuerung
{
	// instance variables - replace the example below with your own#
	//Arrays sind hier meist Schwachsinn, LinkedLists/Baueme eigenen sich hier besser.
	
	private GUI dieGUI;
	private FlugBuchung[] dieFlugBuchung=new FlugBuchung[10000];
	private Passagier[] derPassagier = new Passagier[10000];
	private int aAnzahlBuchungen=0; // int weil GZ
	private int aAnzahlPassagiere=0; // int weil GZ
	private String aEntfernung[][] = { { "Heidelberg", "70" },
			{ "New York", "5000" }, {"Rio de Janeiro", "7000"} }; // string weil da ein text ist

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
		for(int i=0; i<aAnzahlPassagiere;i++)
		{
			if(derPassagier[i]!=null)
			{
				if (pName.equals(derPassagier[i].gibName())
						&& pVName.equals(derPassagier[i].gibVorname()))
				{
					dieFlugBuchung[aAnzahlBuchungen++]=new FlugBuchung(i,pDatum,pReiseziel);
					return;
				}
			}
		}
	}

	public boolean storniereBuchung(int pPassNr, String pDatum)
	{
		int idxMerk=-1;
		int i=0;
		while(i<aAnzahlBuchungen&&idxMerk==-1)
		{
			int diePassNr=dieFlugBuchung[i].gibPassagierNr();
			String dasDatum=dieFlugBuchung[i].gibDatum();
			if(diePassNr==pPassNr&&dasDatum.equals(pDatum))
			{
				idxMerk=i;
			}
			else
			{
				i++;
			}
		}
		if(idxMerk==-1)
		{
			return false;
		}
		else
		{
			for(i=idxMerk; i<aAnzahlBuchungen-2; i++)
			{
				//Wofür gibt es denn LinkedLists?
				dieFlugBuchung[i]=dieFlugBuchung[i+1];
			}
			aAnzahlBuchungen--;
			return true;			
		}		
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
			dieGUI.anzeigenText("Status fuer " + vName + " " + name, status);
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
		for (int i = 0; i < aAnzahlPassagiere && !pGefunden; i++)
		{
			if (derPassagier[i] != null)
			{
				if (pName.equals(derPassagier[i].gibName())
						&& pVName.equals(derPassagier[i].gibVorname()))
				{
					pGefunden = true;
					for (int j = 0; j < aAnzahlBuchungen && !zGefunden; j++)
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
		s.aAnzahlPassagiere=1230;
		s.dieGUI.clickNeuerPassagier();
		s.dieGUI.clickNeueBuchung();
		s.dieGUI.clickAnzeigeReiseziel();
		s.dieGUI.clickGutschreibenMeilen();
	}
		
	
}
