import {Component, inject} from '@angular/core';
import {Router} from '@angular/router';
import {FormsModule} from "@angular/forms";
import {NgClass} from "@angular/common";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {UserService} from "../../services/user.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  standalone: true,
  imports: [
    FormsModule,
    HttpClientModule
  ],
  styleUrl: './login.component.css'
})
export class LoginComponent {

  loginObj: any = {
    "Email": "",
    "Password": ""
  }

  router = inject(Router);

  constructor(private userSrv: UserService) {

  }

  login() {
    debugger;
    this.userSrv.onLogin(this.loginObj).subscribe((res: any) => {
      debugger;
      if (res.result) {
        localStorage.setItem('angular17TokenData', JSON.stringify(res.data));
        localStorage.setItem('angular17TokenEmail', res.data.emailId);
        localStorage.setItem('angular17TokenUserId', res.data.userId);
        this.router.navigateByUrl('/dashboard');
      } else {
        alert(res.message)
      }
    }, error => {
      alert("Wrong Credentials")
    })
  }
}
