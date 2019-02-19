module.exports = {
  configureWebpack: {
    devtool: 'source-map'
  },
  devServer: {
    proxy: {
      '^/api': {
        host: 'localhost',
        target: 'https://math.vpv.io',
        ws: true,
        changeOrigin: true,
        headers: {
          host: 'math.vpv.io'
        }
      },
      '/login': {
        target: 'https://math.vpv.io',
        host: 'localhost',
        changeOrigin: false,
        headers: {
          host: 'math.vpv.io'
        },
        pathRewrite: {
          '/login': '/login'
        }
      },
      '/signin': {
        target: 'https://math.vpv.io',
        host: 'localhost',
        changeOrigin: false,
        headers: {
          host: 'math.vpv.io'
        },
        logLevel: 'debug',
        pathRewrite: function (path, req) {
          let resultPath = path + '?key=local'
          console.log('Path returned', resultPath)
          return resultPath
        }
      },
      '/logout': {
        target: 'https://math.vpv.io',
        host: 'localhost',
        changeOrigin: false,
        headers: {
          host: 'math.vpv.io'
        },
        pathRewrite: function (path, req) {
          let resultPath = path + '?key=local'
          console.log('Path returned', resultPath)
          return resultPath
        }
      }
    }
  }
}
