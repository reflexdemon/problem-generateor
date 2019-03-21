<template>
  <div class="printable">
    <p>Printable Math Problem {{data.meta.created}} <span style="color: #444; font-size: 10px">https://math.vpv.io</span></p>
    <div class="row">

      <div class="column" v-for="r in data.data" :key="r.$index">
          <span class="cell" v-for="i in r" :key="i.$index">
            <div >{{i.firstNumber}}</div>
            <div >{{i.operator}} {{i.secondNumber}}</div>
            <hr>
            <br>
            <hr>
          </span>
      </div>
</div>

  </div>
</template>
<style scoped>
* {
  box-sizing: border-box;
}

/* Create three equal columns that floats next to each other */
.column {
  float: left;
  padding: 0px;
}

.cell {
  height: 100px;
  text-align: right;
  font-family: "Courier New", Courier, monospace;
  border: 1px solid #000000;
  display: block;
  padding: 10px;
}
.row {
  align-content: center;
}
/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}

</style>

<script src="./Printable.vue.ts"></script>
