export class CalendarItem{
	private projectName: string;
	private date: Date;
	private content: string;
	private checked: boolean;
	private id: string;

	constructor(projectName, date, content, checked) {
		this.projectName = projectName;
		this.date = date;
		this.content = content;
		this.checked = checked;
	}

	getPorjectName(){
		return this.projectName;
	}

	setId(id: any) {
		this.id = id;
	}

	getId() {
		return this.id;
	}

	setContent(value: any) {
		this.content = value;
	}
}