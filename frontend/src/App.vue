

<template>
    <v-app id="inspire">
        <div>
            <v-app-bar app clipped-left flat>
                <v-toolbar-title>
                    <span class="second-word font uppercase"
                        style="font-weight:700;"
                    >
                        <v-app-bar-nav-icon
                            @click="openSideBar()"
                            style="z-index:1;
                            height:56px;
                            width:30px;
                            margin-right:10px;
                            font-weight:300;
                            font-size:55px;"
                        >
                            <div style="line-height:100%;">≡</div>
                        </v-app-bar-nav-icon>
                        newaccount
                    </span>
                </v-toolbar-title>
                <v-spacer></v-spacer>
            </v-app-bar>

            <v-navigation-drawer app clipped flat v-model="sideBar">
                <v-list>


                    <v-list-item
                        class="px-2"
                        key="preApplicationAS"
                        to="/preApplicationAS"
                        color="deep-purple lighten-2"
                        style="font-weight:700;"
                    >
                        PreApplicationA
                    </v-list-item>



                    <v-list-item
                        class="px-2"
                        key="incomeVerificationResultAS"
                        to="/incomeVerificationResultAS"
                        color="deep-purple lighten-2"
                        style="font-weight:700;"
                    >
                        IncomeVerificationResultA
                    </v-list-item>



                    <v-list-item
                        class="px-2"
                        key="accountAS"
                        to="/accountAS"
                        color="deep-purple lighten-2"
                        style="font-weight:700;"
                    >
                        AccountA
                    </v-list-item>



                    <v-list-item
                        class="px-2"
                        key="appliedResultRS"
                        to="appliedResultRS"
                        color="deep-purple lighten-2"
                        style="font-weight:700;"
                    >
                        AppliedResultR
                    </v-list-item>

                    <v-list-item
                        class="px-2"
                        key="externalChecks"
                        to="/externalChecks"
                        color="deep-purple lighten-2"
                        style="font-weight:700;"
                    >
                        ExternalCheck
                    </v-list-item>




                </v-list>
            </v-navigation-drawer>
        </div>

        <v-main>
            <v-container class="py-8 px-6" fluid>
                <router-view></router-view>
            </v-container>
        </v-main>
    </v-app>
</template>

<script>
export default {
    name: "App",

    components: {},

    data: () => ({
        useComponent: "",
        drawer: true,
        components: [],
        sideBar: true,
    }),

    mounted() {
        var me = this;
        me.components = this.$ManagerLists;
    },

    methods: {
        openSideBar(){
            this.sideBar = !this.sideBar
        }
    }
};
</script>
<style>
</style>
