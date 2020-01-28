import { Component, OnInit } from '@angular/core';
import { AuthServiceService } from '../service/auth-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

  constructor(private authService:AuthServiceService,
    private router:Router) { }

  ngOnInit() {
    this.authService.logOut();
    this.router.navigate(['login']);
  }

}
