<template>
    <v-card outlined>
        <v-card-title>
            ExternalCheck # {{item._links.self.href.split("/")[item._links.self.href.split("/").length - 1]}}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="RegNo" v-model="item.regNo" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="IncomeExtAmt" v-model="item.incomeExtAmt" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>
</template>


<script>
    const axios = require('axios').default;

    export default {
        name: 'ExternalCheckDetail',
        components:{},
        props: {
        },
        data: () => ({
            item: null,
        }),
        async created() {
            var me = this;
            var params = this.$route.params;
            var temp = await axios.get(axios.fixUrl('/externalChecks/' + params.id))
            if(temp.data) {
                me.item = temp.data
            }
        },
        methods: {
        },
    };
</script>
