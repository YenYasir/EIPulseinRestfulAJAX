import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue()],
  resolve:{
    alias:{
      '@':'/src',
    }
  },
  server:{
    proxy:{
      '/restfulajaxdemo':{
        target:'http://localhost:8050',
        changeOrigin:true,
        rewrite:(path)=>path.replace(/^\/restfulajaxdemo/, '')
      
      }
    }
  }
})