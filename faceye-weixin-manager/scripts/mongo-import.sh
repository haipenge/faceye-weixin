mongo_path='/tools/mongodb/mongodb-osx-x86_64-2.6.3/bin/'
#dir='/app/build/source/faceye-security/faceye-security-manager-mongo'
dir='/work/Work/FeatureWorkSpace/feature/faceye-weixin/faceye-weixin-manager/data/init'
db=$1
cd /tools/mongodb/mongodb-osx-x86_64-3.0.1/bin
#cd /app/mongo/mongodb-linux-x86_64-3.0.1/bin
./mongoimport -d $db -c weixin_account $dir/weixin_account
./mongoimport -d $db -c weixin_responseMessageType $dir/weixin_responseMessageType
./mongoimport -d $db -c weixin_response_content $dir/weixin_response_content
./mongoimport -d $db -c weixin_response_content_item $dir/weixin_response_content_item
./mongoimport -d $db -c weixin_response_message_type $dir/weixin_response_message_type
./mongoimport -d $db -c weixin_weixin $dir/weixin_weixin