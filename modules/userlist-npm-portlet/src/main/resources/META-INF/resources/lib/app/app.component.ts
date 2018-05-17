import { Component } from '@angular/core';

export class LiferayUser {
    agreedToTermsOfUse: boolean;
    comments: string;
    companyId: number;
    contactId: number;
    createDate: number;
    defaultUser: boolean;
    emailAddress: string;
    emailAddressVerified: boolean;
    facebookId: number;
    failedLoginAttempts: number;
    firstName: string;
    googleUserId: string;
    graceLoginCount: number;
    greeting: string;
    jobTitle: string;
    languageId: string;
    lastFailedLoginDate: number;
    lastLoginDate: number;
    lastLoginIP: string;
    lastName: string;
    ldapServerId: string;
    lockout: boolean;
    lockoutDate: number;
    loginDate: number;
    loginIP: string;
    middleName: string;
    modifiedDate: number;
    mvccVersion: string;
    openId: string;
    portraitId: string;
    reminderQueryAnswer: string;
    reminderQueryQuestion: string;
    screenName: string;
    status: number;
    timeZoneId: string;
    userId: string;
    uuid: string;
}

@Component({
	template: `
	<div>
        <button (click)="getLiferayCompanyUsers()">
            Click to load users...
        </button>
    </div>
    
    <div *ngIf="userList && userList.length > 0">
        <div *ngIf="!selectedUser">
            <h1>Liferay Heroes</h1>
            <div>
                <ul>
                    <li *ngFor="let user of userList" (click)="selectUser(user)">
                    {{user.lastName}} {{user.middleName}} {{user.firstName}} 
                    </li>
                </ul>
            </div>
        </div>
        <div *ngIf="selectedUser">
            <h1>User details</h1>
            <button (click)="selectedUser = null">Back to list</button>
            <div><label>agreedToTermsOfUse: </label>{{selectedUser.agreedToTermsOfUse}}</div>
            <div><label>comments: </label>{{selectedUser.comments}}</div>
            <div><label>companyId: </label>{{selectedUser.companyId}}</div>
            <div><label>contactId: </label>{{selectedUser.contactId}}</div>
            <div><label>createDate: </label>{{selectedUser.createDate}}</div>
            <div><label>defaultUser: </label>{{selectedUser.defaultUser}}</div>
            <div><label>emailAddress: </label>{{selectedUser.emailAddress}}</div>
            <div><label>emailAddressVerified: </label>{{selectedUser.emailAddressVerified}}</div>
            <div><label>facebookId: </label>{{selectedUser.facebookId}}</div>
            <div><label>failedLoginAttempts: </label>{{selectedUser.failedLoginAttempts}}</div>
            <div><label>firstName: </label>{{selectedUser.firstName}}</div>
            <div><label>googleUserId: </label>{{selectedUser.googleUserId}}</div>
            <div><label>graceLoginCount: </label>{{selectedUser.graceLoginCount}}</div>
            <div><label>greeting: </label>{{selectedUser.greeting}}</div>
            <div><label>jobTitle: </label>{{selectedUser.jobTitle}}</div>
            <div><label>languageId: </label>{{selectedUser.languageId}}</div>
            <div><label>lastFailedLoginDate: </label>{{selectedUser.lastFailedLoginDate}}</div>
            <div><label>lastLoginDate: </label>{{selectedUser.lastLoginDate}}</div>
            <div><label>lastLoginIP: </label>{{selectedUser.lastLoginIP}}</div>
            <div><label>lastName: </label>{{selectedUser.lastName}}</div>
            <div><label>ldapServerId: </label>{{selectedUser.ldapServerId}}</div>
            <div><label>lockout: </label>{{selectedUser.lockout}}</div>
            <div><label>lockoutDate: </label>{{selectedUser.lockoutDate}}</div>
            <div><label>loginDate: </label>{{selectedUser.loginDate}}</div>
            <div><label>loginIP: </label>{{selectedUser.loginIP}}</div>
            <div><label>middleName: </label>{{selectedUser.middleName}}</div>
            <div><label>modifiedDate: </label>{{selectedUser.modifiedDate}}</div>
            <div><label>mvccVersion: </label>{{selectedUser.mvccVersion}}</div>
            <div><label>openId: </label>{{selectedUser.openId}}</div>
            <div><label>portraitId: </label>{{selectedUser.portraitId}}</div>
            <div><label>reminderQueryAnswer: </label>{{selectedUser.reminderQueryAnswer}}</div>
            <div><label>reminderQueryQuestion: </label>{{selectedUser.reminderQueryQuestion}}</div>
            <div><label>screenName: </label>{{selectedUser.screenName}}</div>
            <div><label>status: </label>{{selectedUser.status}}</div>
            <div><label>timeZoneId: </label>{{selectedUser.timeZoneId}}</div>
            <div><label>userId: </label>{{selectedUser.userId}}</div>
            <div><label>uuid: </label>{{selectedUser.uuid}}</div>
        </div>  
    </div>
    `,
})

export class AppComponent {
	userList: Array<LiferayUser> = [];
	selectedUser: LiferayUser = null;
	
    liferayRestService = window['Liferay'].Service;
	serviceURL: string = "/user/get-company-users";
	serviceArgumens: any = {
        companyId: 20115,
        start: -1,
        end: -1
    };
	serviceResponseHandler = (response: any) => {
	   console.log(response);
	   this.userList = response;
	};
	
    getLiferayCompanyUsers = () => 
        this.liferayRestService(
            this.serviceURL,
            this.serviceArgumens,
            this.serviceResponseHandler
        );
    
    selectUser = (user: LiferayUser) => {
        if (this.selectedUser === user) return;
        this.selectedUser = user;
    }
    
}
