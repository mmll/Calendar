export class Project{
  private _title;
  private _description;
  private _coverUrl;
  get title() {
    return this._title;
  }

  set title(value) {
    this._title = value;
  }

  get description() {
    return this._description;
  }

  set description(value) {
    this._description = value;
  }

  get coverUrl() {
    return this._coverUrl;
  }

  set coverUrl(value) {
    this._coverUrl = value;
  }
  constructor(title, description, coverUrl){
    this.title = title;
    this.description = description;
    this.coverUrl = coverUrl;
  }
}
