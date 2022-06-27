
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import PreApplicationAManager from "./components/listers/PreApplicationACards"
import PreApplicationADetail from "./components/listers/PreApplicationADetail"

import IncomeVerificationResultAManager from "./components/listers/IncomeVerificationResultACards"
import IncomeVerificationResultADetail from "./components/listers/IncomeVerificationResultADetail"

import AccountAManager from "./components/listers/AccountACards"
import AccountADetail from "./components/listers/AccountADetail"


import AppliedResultRView from "./components/AppliedResultRView"
import AppliedResultRViewDetail from "./components/AppliedResultRViewDetail"
import ExternalCheckManager from "./components/listers/ExternalCheckCards"
import ExternalCheckDetail from "./components/listers/ExternalCheckDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/preApplicationAS',
                name: 'PreApplicationAManager',
                component: PreApplicationAManager
            },
            {
                path: '/preApplicationAS/:id',
                name: 'PreApplicationADetail',
                component: PreApplicationADetail
            },

            {
                path: '/incomeVerificationResultAS',
                name: 'IncomeVerificationResultAManager',
                component: IncomeVerificationResultAManager
            },
            {
                path: '/incomeVerificationResultAS/:id',
                name: 'IncomeVerificationResultADetail',
                component: IncomeVerificationResultADetail
            },

            {
                path: '/accountAS',
                name: 'AccountAManager',
                component: AccountAManager
            },
            {
                path: '/accountAS/:id',
                name: 'AccountADetail',
                component: AccountADetail
            },


            {
                path: '/appliedResultRS',
                name: 'AppliedResultRView',
                component: AppliedResultRView
            },
            {
                path: '/appliedResultRS/:id',
                name: 'AppliedResultRViewDetail',
                component: AppliedResultRViewDetail
            },
            {
                path: '/externalChecks',
                name: 'ExternalCheckManager',
                component: ExternalCheckManager
            },
            {
                path: '/externalChecks/:id',
                name: 'ExternalCheckDetail',
                component: ExternalCheckDetail
            },



    ]
})
