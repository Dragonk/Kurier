package interfejs;

public interface Odczyt 
{
	public static void WczytajDaneZDysku(String sciezka)//2 arg: gdzie (komponent)
	{
		//pobiera i wyswietla ich nazwy w komponencie txtowym
	}
	
	private boolean ToMetadana()
	{
	// return sprawdz rodzaj danych;
	}
	private boolean ToSOAP()
	{
		return  sprawdz rodzaj danych;
	}
	public static String WezNazwyMetaDanych() //1 arg: tablica/macierz z wczytanymi danymi, podpowiadam
	{
		get{return nazwy;}
		
	}
	public static String[] WezNazwySOAP() // String[][]
	{
		get{return nazwy;}
		//tablica jednowymiarowa albo macierz 
	}
	private boolean DaneIstniejaWKatalogu()
	{
	//sprawdz czy dane istnieja na dysku
	}
	private boolean WczytanoDane()
	{
		//zwykla flaga
	}
	private boolean WczytywanieDanych()
	{
		//zwykla flaga
	}
}