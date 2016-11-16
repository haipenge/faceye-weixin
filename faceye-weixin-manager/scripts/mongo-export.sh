cd  /tools/mongodb/mongodb-osx-x86_64-3.0.1/bin
db=search
./mongoexport -d $db -c weixin_account -o /work/Work/FeatureWorkSpace/feature/faceye-weixin/faceye-weixin-manager/data/init/weixin_account
./mongoexport -d $db -c weixin_responseMessageType -o /work/Work/FeatureWorkSpace/feature/faceye-weixin/faceye-weixin-manager/data/init/weixin_responseMessageType
./mongoexport -d $db -c weixin_response_content -o /work/Work/FeatureWorkSpace/feature/faceye-weixin/faceye-weixin-manager/data/init/weixin_response_content
./mongoexport -d $db -c weixin_response_content_item -o /work/Work/FeatureWorkSpace/feature/faceye-weixin/faceye-weixin-manager/data/init/weixin_response_content_item
./mongoexport -d $db -c weixin_response_message_type -o /work/Work/FeatureWorkSpace/feature/faceye-weixin/faceye-weixin-manager/data/init/weixin_response_message_type
./mongoexport -d $db -c weixin_weixin -o /work/Work/FeatureWorkSpace/feature/faceye-weixin/faceye-weixin-manager/data/init/weixin_weixin
