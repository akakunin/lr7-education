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
	<div *ngIf="!selectedUser">
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
            <h1> 
                <a class="control-menu-icon" (click)="selectedUser = null">
                    <span class="icon-monospaced" id="oxcj__null__null">
                        <svg class="lexicon-icon lexicon-icon-angle-left" focusable="false" role="img" title="" viewBox="0 0 512 512">
                            <title>angle-left</title>
                            <path class="lexicon-icon-outline" d="M114.106 254.607c0.22 6.936 2.972 13.811 8.272 19.11l227.222 227.221c11.026 11.058 28.94 11.058 39.999 0 11.058-11.026 11.058-28.94 0-39.999l-206.333-206.333c0 0 206.333-206.333 206.333-206.333 11.058-11.059 11.058-28.973 0-39.999-11.058-11.059-28.973-11.059-39.999 0l-227.221 227.221c-5.3 5.3-8.052 12.174-8.273 19.111z"></path>
                        </svg>
                    </span>
                </a> 
                {{selectedUser.lastName}} {{selectedUser.middleName}} {{selectedUser.firstName}}
            </h1>
<fieldset aria-labelledby="detailsTitle" class=" " id="details" role="group">
    <div aria-labelledby="detailsHeader" class="in " id="detailsContent" role="presentation">
        <div class="panel-body">
            <div class="row">
                <fieldset class="fieldset col-md-6">
                    <div class="">
                        <div class="form-group input-String-wrapper">
                            <label class="control-label" for="_com_liferay_users_admin_web_portlet_UsersAdminPortlet_screenName">
                                Screen Name 
                                <span class="text-warning" id="qfkd__null__null">
                                    <svg class="lexicon-icon lexicon-icon-asterisk" focusable="false" role="img" title="" viewBox="0 0 512 512">
                                        <title>asterisk</title>
                                        <path class="lexicon-icon-outline" d="M323.6,190l146.7-48.8L512,263.9l-149.2,47.6l93.6,125.2l-104.9,76.3l-96.1-126.4l-93.6,126.4L56.9,435.3l92.3-123.9
                                            L0,263.8l40.4-122.6L188.4,190v-159h135.3L323.6,190L323.6,190z"></path>
                                    </svg>
                                </span>
                                <span class="hide-accessible">Required</span> 
                            </label>
                            <input class="field form-control lfr-input-text" id="_com_liferay_users_admin_web_portlet_UsersAdminPortlet_screenName" name="_com_liferay_users_admin_web_portlet_UsersAdminPortlet_screenName" style="" type="text" value="{{selectedUser.screenName}}" maxlength="75" aria-describedby="" aria-required="true" disabled> 
                        </div>
                        <div class="form-group input-String-wrapper">
                            <label class="control-label" for="_com_liferay_users_admin_web_portlet_UsersAdminPortlet_emailAddress">
                                Email Address 
                                <span class="text-warning" id="jbfs__null__null">
                                    <svg class="lexicon-icon lexicon-icon-asterisk" focusable="false" role="img" title="" viewBox="0 0 512 512">
                                        <title>asterisk</title>
                                        <path class="lexicon-icon-outline" d="M323.6,190l146.7-48.8L512,263.9l-149.2,47.6l93.6,125.2l-104.9,76.3l-96.1-126.4l-93.6,126.4L56.9,435.3l92.3-123.9
                                            L0,263.8l40.4-122.6L188.4,190v-159h135.3L323.6,190L323.6,190z"></path>
                                    </svg>
                                </span>
                                <span class="hide-accessible">Required</span> 
                            </label>
                            <input class="field form-control lfr-input-text" id="_com_liferay_users_admin_web_portlet_UsersAdminPortlet_emailAddress" name="_com_liferay_users_admin_web_portlet_UsersAdminPortlet_emailAddress" style="" type="text" value="{{selectedUser.emailAddress}}" maxlength="254" aria-describedby="" aria-required="true" disabled> 
                        </div>
                        <div class="form-group input-select-wrapper">
                            <label class="control-label" for="_com_liferay_users_admin_web_portlet_UsersAdminPortlet_languageId"> Language </label> 
                            <input class="field form-control lfr-input-text" id="_com_liferay_users_admin_web_portlet_UsersAdminPortlet_languageId" name="_com_liferay_users_admin_web_portlet_UsersAdminPortlet_languageId" type="text" value="{{selectedUser.languageId}}" maxlength="254" aria-describedby="" aria-required="true" disabled>
                        </div>
                        <div id="_com_liferay_users_admin_web_portlet_UsersAdminPortlet_userNameFields">
                            <div class="form-group input-select-wrapper">
                                <label class="control-label" for="_com_liferay_users_admin_web_portlet_UsersAdminPortlet_prefixValue"> Prefix </label> 
                                <select class="field form-control lfr-input-text" id="_com_liferay_users_admin_web_portlet_UsersAdminPortlet_prefixValue" name="_com_liferay_users_admin_web_portlet_UsersAdminPortlet_prefixValue" type="text" value="" maxlength="254" aria-describedby="" aria-required="true">
                                    <option class="" value=""> </option>
                                    <option class="" value="Dr"> Dr </option>
                                    <option class="" value="Mr"> Mr </option>
                                    <option class="" value="Ms"> Ms </option>
                                    <option class="" value="Mrs"> Mrs </option>
                                </select>
                            </div>
                            <div class="form-group input-String-wrapper">
                                <label class="control-label" for="_com_liferay_users_admin_web_portlet_UsersAdminPortlet_firstName">
                                    First Name 
                                    <span class="text-warning" id="uvlz__null__null">
                                        <svg class="lexicon-icon lexicon-icon-asterisk" focusable="false" role="img" title="" viewBox="0 0 512 512">
                                            <title>asterisk</title>
                                            <path class="lexicon-icon-outline" d="M323.6,190l146.7-48.8L512,263.9l-149.2,47.6l93.6,125.2l-104.9,76.3l-96.1-126.4l-93.6,126.4L56.9,435.3l92.3-123.9
                                                L0,263.8l40.4-122.6L188.4,190v-159h135.3L323.6,190L323.6,190z"></path>
                                        </svg>
                                    </span>
                                    <span class="hide-accessible">Required</span> 
                                </label>
                                <input class="field form-control lfr-input-text" id="_com_liferay_users_admin_web_portlet_UsersAdminPortlet_firstName" name="_com_liferay_users_admin_web_portlet_UsersAdminPortlet_firstName" style="" type="text" value="{{selectedUser.firstName}}" maxlength="75" aria-describedby="" aria-required="true" disabled> 
                            </div>
                            <div class="form-group input-String-wrapper"> <label class="control-label" for="_com_liferay_users_admin_web_portlet_UsersAdminPortlet_middleName"> Middle Name </label> <input class="field form-control lfr-input-text" id="_com_liferay_users_admin_web_portlet_UsersAdminPortlet_middleName" name="_com_liferay_users_admin_web_portlet_UsersAdminPortlet_middleName" style="" type="text" value="{{selectedUser.middleName}}" maxlength="75" aria-describedby="" disabled> </div>
                            <div class="form-group input-String-wrapper">
                                <label class="control-label" for="_com_liferay_users_admin_web_portlet_UsersAdminPortlet_lastName">
                                    Last Name 
                                    <span class="text-warning" id="ored__null__null">
                                        <svg class="lexicon-icon lexicon-icon-asterisk" focusable="false" role="img" title="" viewBox="0 0 512 512">
                                            <title>asterisk</title>
                                            <path class="lexicon-icon-outline" d="M323.6,190l146.7-48.8L512,263.9l-149.2,47.6l93.6,125.2l-104.9,76.3l-96.1-126.4l-93.6,126.4L56.9,435.3l92.3-123.9
                                                L0,263.8l40.4-122.6L188.4,190v-159h135.3L323.6,190L323.6,190z"></path>
                                        </svg>
                                    </span>
                                    <span class="hide-accessible">Required</span> 
                                </label>
                                <input class="field form-control lfr-input-text" id="_com_liferay_users_admin_web_portlet_UsersAdminPortlet_lastName" name="_com_liferay_users_admin_web_portlet_UsersAdminPortlet_lastName" style="" type="text" value="{{selectedUser.lastName}}" maxlength="75" aria-describedby="" aria-required="true" disabled> 
                            </div>
                        </div>
                    </div>
                </fieldset>
            </div>
        </div>
    </div>
</fieldset>
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
