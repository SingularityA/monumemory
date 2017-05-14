yieldUnescaped '<!DOCTYPE html>'
html {
  head {
    title(title)
    link(rel:'stylesheet', media:'screen, projection', href:'https://fonts.googleapis.com/icon?family=Material+Icons')
    link(type:'text/css', rel:'stylesheet', href:'/css/materialize.css', media:'screen, projection')
    link(type:'text/css', rel:'stylesheet', href:'/css/main.css', media:'screen, projection')
  }
  body {
    header() {
      nav(class:'top-nav light-green darken-3') {
        div(class:'container') {
          div(class:'nav-wrapper') {
            a(class:'page-title', 'Momumemory')
          }
        }
      }
    }
    div (class:'container') {
      content()
    }
    footer(class:'page-footer light-green darken-3') {
      div(class:'container') {
        div(class:'row') {
          div(class:'col l6 s12') {
            h5(class:'white-text') {
              yield 'Info'
            }
            p(class:'grey-text text-lighten-4') {
              yield 'Some information to add later'
            }
          }
          div(class:'col l4 offset-l2 s12') {
            h5(class:'white-text') {
              yield 'Links'
            }
            ul {
              li {
                a(class:'grey-text text-lighten-3', href:"#!") {
                  yield 'Link 1'
                }
              }
              li {
                a(class:'grey-text text-lighten-3', href:"#!") {
                  yield 'Link 2'
                }
              }
            }
          }
        }
      }
      div(class:'footer-copyright') {
        div(class:'container') {
          yield '© 2017 By SingularityA'          
        }
      }
    }
    script(type:'text/javascript', src:'/js/jquery.js') {}
    script(type:'text/javascript', src:'/js/materialize.js') {}
    script(type:'text/javascript', src:'https://cdn.jsdelivr.net/jquery.validation/1.15.0/jquery.validate.min.js') {}
  }
}
