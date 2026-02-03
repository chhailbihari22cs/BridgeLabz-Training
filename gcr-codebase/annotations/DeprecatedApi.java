class LegacyAPI{
	@Deprecated
    public void oldFeature() {
        System.out.println("Old feature: Not recommended to use");
    }

    public void newFeature() {
        System.out.println("New feature: Use this instead");
    }
}
public class DeprecatedApi {

	public static void main(String[] args) {
		
		LegacyAPI api = new LegacyAPI();
		api.oldFeature();
		api.newFeature();

	}

}
