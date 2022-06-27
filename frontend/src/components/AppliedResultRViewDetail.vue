<template>

    <v-card outlined>
        <v-card-title>
            AppliedResultR # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="CustNo" v-model="item.custNo" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="AppliedStatus" v-model="item.appliedStatus" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="IncomeAmount" v-model="item.incomeAmount" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'AppliedResultRViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        appliedResultR : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.backend + '/appliedresultrs/' + params.id)

      this.appliedResultR = temp.data._embedded.appliedresultrs;

    },
    methods: {
    }
  }
</script>

