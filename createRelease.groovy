import com.xebialabs.xlrelease.domain.Release
Release createdRelease = xlr {
  release('New Uname') {
    variables {
      stringVariable('output') {
        required false
        showOnReleaseStart false
      }
      stringVariable('err') {
        required false
        showOnReleaseStart false
      }
    }
    //scheduledStartDate Date.parse("yyyy-MM-dd'T'HH:mm:ssZ", '2018-08-14T13:00:00+0000')
    autoStart(true)
    scriptUsername 'admin'
    scriptUserPassword 'Password'
    phases {
      phase('New Phase') {
        tasks {
          description 'Remote Unix Script'
          custom('uname') {
            script {
              type 'remoteScript.Unix'
              script 'uname -a'
              output variable('output')
              err variable('err')
              address 'localhost'
              username '${global.rundeckuser}'
              privateKeyFile '${global.rundeckkeyfile}'
            }
          }
        }
      }
    }
  }
}
releaseVariables["releaseID"] = createdRelease.id
print "\n This is the Release ID of the newly created Release : - \n"
print releaseVariables["releaseID"]
