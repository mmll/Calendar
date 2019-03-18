export class Project{
  private projectName;
  private description;
  private coverUrl;
  constructor(title, description, coverUrl){
    this.projectName = title;
    this.description = description;
    this.coverUrl = coverUrl;
  }
}
