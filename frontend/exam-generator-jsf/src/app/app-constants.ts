export class AppConstants {

  public static get baseSevidor(): string {
    return "http://localhost:8085/"
  }

  public static get baseLogin(): string{
    return this.baseSevidor + "v1/professor"
  }

  public static get baseUrl(): string{
    return this.baseSevidor + "v1/professor"
  }



}
