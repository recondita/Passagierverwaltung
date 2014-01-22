import javax.swing.JTextField;

/**
 * Write a description of class GUI here.
 * 
 * @author Jan Hofmeier
 * @version (a version number or a date)
 */
public class GUI
{
	private Steuerung dieSteuerung;
	private JTextField ziel = new JTextField("New York");
	private JTextField pNr = new JTextField("1230");
	private JTextField datum = new JTextField("20.01.2011"); 
	private JTextField vName = new JTextField("Hans");
	private JTextField nName = new JTextField("Maier");

	/**
	 * Constructor for objects of class GUI
	 */
	public GUI(Steuerung pS)
	{
		dieSteuerung = pS;
	}

	public void clickNeuerPassagier()
	{
	}

	public void clickNeueBuchung()
	{
	}
	
	public void clickGutschreibenMeilen()
	{
		dieSteuerung.gutschreibenMeilen(readPNrAsInt(), readZielAsText());
	}

	public void clickStorniereBuchung()
	{
	}

	public void clickAnzeigeReiseziel()
	{
		dieSteuerung.anzeigeReiseziel(nName.getText(), vName.getText(), datum.getText());
	}

	public void anzeigenText(String p1, String pW2)
	{
		System.out.println(p1+": "+pW2);
	}

	private int readPNrAsInt()
	{
		return Integer.parseInt(pNr.getText());
	}
	
	private String readZielAsText()
	{
		return ziel.getText();
	}
}
