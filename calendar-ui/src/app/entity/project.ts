export class Project{
  private projectName;
  private description;
  private coverFile: string| Blob;
  constructor(title, description, coverFile){
    this.projectName = title;
    this.description = description;
    this.coverFile = coverFile;
  }
  getProjectName(){
    return this.projectName;
  }

  getDescription(){
    return this.description;
  }

  getCoverFile(){
    return this.coverFile;
  }
}
