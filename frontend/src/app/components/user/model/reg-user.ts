export class RegUser {
  name?: string;
  surname?: string;
  email?: string;
  password?: string;

  static cloneBase(user: RegUser): RegUser {
    let cloneUser: RegUser = new RegUser();
    cloneUser.email = user.email;
    cloneUser.password = user.password;
    cloneUser.name = user.name;
    return cloneUser;
  }

}

