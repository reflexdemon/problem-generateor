import { Component, Vue } from 'vue-property-decorator'
import * as _ from 'lodash'
export class Problem {
  firstNumber?:number|string;
  secondNumber?:number|string;
  operator?:string;
}

@Component({
  components: {
  }
})
export default class Home extends Vue {
  data:any = {
    data: [],
    meta: {
      create: new Date().toString()
    }
  };
  counter:number = 0;
  responseCount:number = 0;
  resultCollection:Array<Problem> = [] as Array<Problem>;
  created () {
    this.problemData()
  }
  problemData () {
    fetch('/api/add?size=90&min=1&max=18')
      .then(response => response.json())
      .then(this.onData.bind(this))
      .catch(this.errorHandler.bind(this))

    fetch('/api/sub?size=90&min=1&max=18')
      .then(response => response.json())
      .then(this.onData.bind(this))
      .catch(this.errorHandler.bind(this))
  }
  onData (result:Array<Problem>) {
    this.responseCount++
    let parsed:Array<Array<Problem>> = [] as Array<Array<Problem>>
    let column:Array<Problem> = [] as Array<Problem>

    console.log('Data:', result)
    this.resultCollection.push(...result)
    if (this.resultCollection.length === 1) {
      return
    }
    var collectedValues = _.shuffle(_.flattenDeep(this.resultCollection))
    _.forEach(collectedValues, (item) => {
      // console.log(item);
      // answers.push(item.answer);
      // console.log(spacePad(item.firstNumber, 2));
      // console.log(spacePad(item.secondNumber, 2) + ' ' + item.operator);
      // console.log('_____\n\n_____');
      column.push({
        firstNumber: this.spacePad(item.firstNumber, 2),
        secondNumber: this.spacePad(item.secondNumber, 2),
        operator: item.operator
      })
      if ((++this.counter % 9) === 0) {
        // console.log('\n');
        parsed.push(column)
        column = []
      }
    })
    this.data = {
      data: parsed,
      meta: {
        created: new Date().toString()
      }
    }
  }
  spacePad (num:any, places:any) {
    let space = places - num.toString().length + 1
    return Array(+(space > 0 && space)).join(' ') + num
  }
  errorHandler (err:any) {
    console.log('Data is not available', err)
  }
}
