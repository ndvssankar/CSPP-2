public class Student {
	private String name;

	public Student(String name) {
		this.name = name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Student)) {
			return false;
		}

		Student that = (Student)other;
		return this.getName().equals(that.getName());
	}

	public String toString() {
		return this.name;
	}
}