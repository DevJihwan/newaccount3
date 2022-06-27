<template>

    <v-data-table
        :headers="headers"
        :items="appliedResultR"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'AppliedResultRView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "custNo", value: "custNo" },
                { text: "appliedStatus", value: "appliedStatus" },
                { text: "incomeAmount", value: "incomeAmount" },
            ],
            appliedResultR : [],
        }),
          async created() {
            var temp = await axios.get(axios.backend + '/appliedresultrs')

            this.appliedResultR = temp.data._embedded.appliedresultrs;
        },
        methods: {
        }
    }
</script>

