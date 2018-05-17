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
        <a class="btn btn-action btn-primary" (click)="getLiferayCompanyUsers()" data-placement="left" data-qa-id="addButton" data-toggle="tooltip" id="_com_liferay_users_admin_web_portlet_UsersAdminPortlet_menuItem" title="" data-original-title="User">
<span id="jbfs__null__null">
    <svg class="lexicon-icon lexicon-icon-search" focusable="false" role="img" title="" viewBox="0 0 512 512">
        <title>search</title>
        <path class="lexicon-icon-outline" d="M503.254 467.861l-133.645-133.645c27.671-35.13 44.344-79.327 44.344-127.415 0-113.784-92.578-206.362-206.362-206.362s-206.362 92.578-206.362 206.362 92.578 206.362 206.362 206.362c47.268 0 90.735-16.146 125.572-42.969l133.851 133.851c5.002 5.002 11.554 7.488 18.106 7.488s13.104-2.486 18.106-7.488c10.004-10.003 10.004-26.209 0.029-36.183zM52.446 206.801c0-85.558 69.616-155.173 155.173-155.173s155.174 69.616 155.174 155.173-69.616 155.173-155.173 155.173-155.173-69.616-155.173-155.173z"></path>
    </svg>
</span>
        </a>
    </div>
    
    <div *ngIf="userList && userList.length > 0">
        <div *ngIf="!selectedUser">
            <h1>Liferay Heroes</h1>
<div class=" users-search-container lfr-search-container-wrapper ">
    <div id="_com_liferay_users_admin_web_portlet_UsersAdminPortlet_users" class="yui3-widget component searchcontainer">
        <div id="_com_liferay_users_admin_web_portlet_UsersAdminPortlet_usersSearchContainer" class="searchcontainer-content">
            <div class="table-responsive">
                <table class="table table-autofit table-heading-nowrap table-list" data-searchcontainerid="_com_liferay_users_admin_web_portlet_UsersAdminPortlet_users">
                    <thead>
                        <tr>
                            <th class="lfr-name-column table-cell-content" id="_com_liferay_users_admin_web_portlet_UsersAdminPortlet_users_col-name"> Full Name </th>
                            <th class="lfr-screen-name-column table-cell-content" id="_com_liferay_users_admin_web_portlet_UsersAdminPortlet_users_col-screen-name"> Screen Name </th>
                            <th class="lfr-email-address-column table-cell-content" id="_com_liferay_users_admin_web_portlet_UsersAdminPortlet_users_col-email-address"> Email Address </th>
                            <th class="lfr-job-title-column table-cell-content" id="_com_liferay_users_admin_web_portlet_UsersAdminPortlet_users_col-job-title"> Job Title </th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr class="" data-qa-id="row" data-selectable="true" *ngFor="let user of userList" (click)="selectUser(user)">
                            <td class="table-cell-content lfr-name-column" colspan="1">
                                <a><strong>{{user.lastName}} {{user.middleName}} {{user.firstName}}</strong></a>
                            </td>
                            <td class="table-cell-content lfr-screen-name-column" colspan="1">
                                <a>{{user.screenName}}</a>
                            </td>
                            <td class="table-cell-content lfr-email-address-column" colspan="1">
                                <a>{{user.emailAddress}}</a>
                            </td>
                            <td class="table-cell-content lfr-job-title-column" colspan="1">
                                <a>{{user.jobTitle}}</a>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
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
	   this.userList = response.filter((user:LiferayUser) => !user.defaultUser);
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
