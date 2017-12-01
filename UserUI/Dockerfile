FROM node:9-alpine

# Create app directory
WORKDIR /usr/src/app

# Install app dependencies
COPY package.json /usr/src/app
# For npm@5 or later, copy package-lock.json as well

RUN npm install && npm install api-ai-javascript
# If you are building your code for production
# RUN npm install

# Bundle app source
COPY . /usr/src/app

EXPOSE 4200

#RUN npm build --prod

#RUN npm i -g angular-cli-ghpages

CMD ["npm", "start"]
