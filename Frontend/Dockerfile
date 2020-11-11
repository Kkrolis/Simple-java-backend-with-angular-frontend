FROM node:14.10.1 AS build
WORKDIR /usr/src/app
COPY package.json ./
RUN npm install
RUN npm run gen
COPY . .
RUN npm run build

### STAGE 2: Run ###
FROM nginx:1.17.1-alpine
COPY default.conf /etc/nginx/conf.d/default.conf
COPY --from=build /usr/src/app/dist/Frontend /usr/share/nginx/html
EXPOSE 4200