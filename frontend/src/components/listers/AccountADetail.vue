<template>
    <v-card outlined>
        <v-card-title>
            AccountA # {{item._links.self.href.split("/")[item._links.self.href.split("/").length - 1]}}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="AcctNo" v-model="item.acctNo" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="CustNo" v-model="item.custNo" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="OpenDate" v-model="item.openDate" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="AccountStatus" v-model="item.accountStatus" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="AccountBalance" v-model="item.accountBalance" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>
</template>


<script>
    const axios = require('axios').default;

    export default {
        name: 'AccountADetail',
        components:{},
        props: {
        },
        data: () => ({
            item: null,
        }),
        async created() {
            var me = this;
            var params = this.$route.params;
            var temp = await axios.get(axios.fixUrl('/accountAS/' + params.id))
            if(temp.data) {
                me.item = temp.data
            }
        },
        methods: {
        },
    };
</script>
