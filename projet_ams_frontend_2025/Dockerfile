FROM node:22.14.0 AS builder

WORKDIR /app


COPY package.json package-lock.json ./


RUN npm install


COPY . .


RUN npm run build -- --configuration=development


FROM nginx:latest


COPY --from=builder /app/dist/xsupply-front/browser /usr/share/nginx/html

EXPOSE 80

ENTRYPOINT ["nginx","-g","daemon off;"]
