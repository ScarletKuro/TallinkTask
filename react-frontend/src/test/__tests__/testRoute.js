/* eslint no-undef: 0 */  // --> OFF
const selenium = require('selenium-webdriver');

const rootURL = 'http://localhost:3000/';

describe('Test Page Routes', function() {

  beforeEach(done => {
    driver.get(rootURL).then(done);
  });

  it('Room Page', done => {
    driver.getCurrentUrl().then(value => {
      expect(value).toBe(rootURL);
      done();
    });
  });

  it('Conference Page', done => {
    driver.wait(driver.findElement(selenium.By.linkText('View')), 2000)
      .then(view => view.click())
      .then(driver.wait(driver.getCurrentUrl(), 2000)
        .then(value => {
          expect(value).toContain('/room/');
          done();
        }));
  });

  it('Participant Page', done => {
    driver.wait(driver.findElement(selenium.By.linkText('View')), 2000)
      .then(view => view.click())
      .then(driver.wait(driver.findElement(selenium.By.linkText('View')), 2000)
        .then(view2 => view2.click())
        .then(driver.wait(driver.getCurrentUrl(), 2000)
          .then(value => {
            expect(value).toContain('/conference/');
            done();
          })));
  });
});

/* eslint no-use-before-define: 2 */  // --> ON
