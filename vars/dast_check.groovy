// def call(){
//                 sh """
//                     zaproxy -cmd \
//                     -port 8090 \
//                     -quickurl http://54.237.233.167:8080/apidocs/ \
//                     -quickout ${WORKSPACE}/zap-report.html \
//                     -quickprogress
//                     """
// }


def call(String targeturl){
                sh """
                    zaproxy -cmd \
                    -port 8090 \
                    -quickurl ${targeturl} \
                    -quickout ${WORKSPACE}/zap-report.html \
                    -quickprogress
                    """
}
