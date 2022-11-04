<template>

    <v-data-table
        :headers="headers"
        :items="orderList"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'OrderListView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
            ],
            orderList : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/orderLists'))

            temp.data._embedded.orderLists.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.orderList = temp.data._embedded.orderLists;
        },
        methods: {
        }
    }
</script>

