FROM node:9.6.1 AS build
WORKDIR /usr/src/react-client
COPY package.json .
RUN npm install
COPY . .
CMD ["npm", "start"]