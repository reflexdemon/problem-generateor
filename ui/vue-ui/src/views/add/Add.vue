<template>
  <div class="add text-xs-center">
    <p>
      <UserInput
            :size="input.size"
            :min="input.min"
            :max="input.max"
            :duration="input.duration"
            title="Addition Problem"
            @activate-timer="activate"
       />
    </p>

    <section id="stopWatch">
      <p id="timer">Time : {{ timer }}</p>
    </section>
    <v-container grid-list-md text-xs-center>
    <v-layout row wrap>
    <v-flex v-for="r in responses" :key="r.$index"  xs12 md6 lg4>
      <ProblemDisplay :response="r" :timer="timer"/>
    </v-flex>
              <v-divider></v-divider>
    <v-flex xs12>
      <v-btn color="success" v-on:click="finish" v-if="responses.length">Finish</v-btn>
    </v-flex>
    </v-layout>
    </v-container>
              <v-divider></v-divider>
    <v-flex xs12>
      <section class="result" v-if="computedResult.total &gt; 0">
      <table border="1" class="results">
        <tr>
            <th>Total Questions </th>
            <td>{{ computedResult.total }}</td>
        </tr>
        <tr>
            <th>Correct Answers </th>
            <td>{{ computedResult.correctAnswers }}</td>
        </tr>
        <tr>
            <th>Your Score</th>
            <td>{{ computedResult.score }}</td>
        </tr>
      </table>
    </section>
    </v-flex>
  </div>
</template>

<script src="./Add.vue.script.js">

</script>
<style scoped>
/* Main column */
.main {
  flex: 30%;
  background-color: #f1f1f1;
  padding: 20px;
  flex-direction: row;
}
/* Responsive layout - when the screen is less than 700px wide, make the two columns stack
   on top of each other instead of next to each other */
@media screen and (max-width: 700px) {
  .main {
    flex-direction: columns;
  }
}
#stopWatch {
  width: 280px;
  height: auto;
  text-align: center;
  display: block;
  padding: 5px;
  margin: 0 auto;
}
#timer,
#fulltime {
  width: auto;
  height: auto;
  padding: 10px;
  font-weight: bold;
  font-family: tahoma;
  display: block;
  border: 1px solid #eee;
  text-align: center;
  box-shadow: 0 0 5px #ccc;
  background: #fbfbf0;
  color: darkblue;
  border-bottom: 4px solid darkgrey;
}
button {
  cursor: pointer;
  font-weight: 700;
}
#fulltime {
  display: none;
  font-size: 16px;
  font-weight: bold;
}
.results {
    margin-left:auto;
    margin-right:auto;
}
table.results {
  border: 3px solid #000000;
  text-align: left;
  border-collapse: collapse;
}
table.results td, table.results th {
  border: 1px solid #000000;
  padding: 5px 10px;
}
table.results tbody td {
  font-size: 13px;
}
table.results th {
  background: #CFCFCF;
  background: -moz-linear-gradient(top, #dbdbdb 0%, #d3d3d3 66%, #CFCFCF 100%);
  background: -webkit-linear-gradient(top, #dbdbdb 0%, #d3d3d3 66%, #CFCFCF 100%);
  background: linear-gradient(to bottom, #dbdbdb 0%, #d3d3d3 66%, #CFCFCF 100%);
  border-right: 3px solid #000000;
}
table.results th {
  font-size: 15px;
  font-weight: bold;
  color: #000000;
  text-align: left;
}
table.results  td {
  font-size: 14px;
}
</style>
