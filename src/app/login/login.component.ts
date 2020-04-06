import { Component, OnInit } from '@angular/core';
import { NgbActiveModal, NgbModal} from '@ng-bootstrap/ng-bootstrap';
import { FormBuilder } from '@angular/forms';
import { LoginService } from '../login.service';


@Component({
  selector: 'login-modal-content',
  template: `
  <div class="modal-header">
   <h4 class="modal-title">Login</h4>
   <button type="button" class="close" aria-label="Close" (click)="activeModal.dismiss('Cross click')">
     <span aria-hidden="true">&times;</span>
   </button>
  </div>
  <form [formGroup]="loginForm" class="form-inline my-2 my-lg-0" (ngSubmit)="onSubmit(loginForm.value)">
    <div class="modal-body mx-3">
      <div class="form-group">
        <label data-error="wrong" data-success="right" for="defaultForm-username">Your username</label><br>
        <input name="username" id="defaultForm-username" class="form-control mr-sm-2 validate" type="text" placeholder="username" formControlName="username">
      </div>
      <div class="form-group">
        <label data-error="wrong" data-success="right" for="defaultForm-pass">Your password</label><br>
        <input name="password" id="defaultForm-pass" class="form-control mr-sm-2" type="password" placeholder="password" formControlName="password"><br>
      </div>
    </div>
    <div class="modal-footer">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Login</button>
      <button type="button" class="btn btn-outline-dark" (click)="activeModal.close('Close click')">Close</button>
    </div>
  </form>
`
})
export class LoginModalContent {
  public loginForm;

  constructor(public activeModal: NgbActiveModal, private formBuilder: FormBuilder, private loginService: LoginService) {
    this.loginForm = this.formBuilder.group({
      username: "",
      password: ""
    });
  }

  public onSubmit(data)
  {
    this.loginService.authenticate(data);
  }
}

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private modalService: NgbModal) { }

  ngOnInit() {
  }

  public open() {
    const modalRef = this.modalService.open(LoginModalContent);
    modalRef.componentInstance.name = "Login";
  }
}
