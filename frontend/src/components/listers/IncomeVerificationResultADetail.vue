<template>
    <v-card outlined>
        <v-card-title>
            IncomeVerificationResultA # {{item._links.self.href.split("/")[item._links.self.href.split("/").length - 1]}}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="CustNo" v-model="item.custNo" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="VerifyResult" v-model="item.verifyResult" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="IncomeAmount" v-model="item.incomeAmount" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="AppliedStatus" v-model="item.appliedStatus" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="RegNo" v-model="item.regNo" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>
</template>


<script>
    const axios = require('axios').default;

    export default {
        name: 'IncomeVerificationResultADetail',
        components:{},
        props: {
        },
        data: () => ({
            item: null,
        }),
        async created() {
            var me = this;
            var params = this.$route.params;
            var temp = await axios.get(axios.fixUrl('/incomeVerificationResultAS/' + params.id))
            if(temp.data) {
                me.item = temp.data
            }
        },
        methods: {
        },
    };
</script>
