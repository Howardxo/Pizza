# Pizza餐廳

## API介紹

| 類型        | API                                       |
|-------------|-------------------------------------------|
| `POST新增`      | http://localhost:8080/api/v1/items             |
| `PUT更新`       | http://localhost:8080/api/v1/update/items/{num}| 
| `DEL刪除`      | http://localhost:8080/api/v1/delete/items/{num}|
| `GET總數查詢`     | http://localhost:8080/api/v1/items             |
| `GET單項查詢`  | http://localhost:8080/api/v1/items/{num}       |
| `GET換頁總數查詢`      | http://localhost:8080/api/v1/items/paged/{pagenum}/{onepagetotalnum}|

## 常用 Commit 類型說明

| 類型        | 說明                                      | 示例                                         |
|-------------|-------------------------------------------|----------------------------------------------|
| `feat`      | 新增功能                                  | `feat(auth): add password recovery`          |
| `fix`       | 修復錯誤                                  | `fix(api): resolve null pointer exception`   |
| `docs`      | 文件變更，例如修改 README 或註解          | `docs: update API usage in README`           |
| `style`     | 代碼風格調整，無邏輯改變，例如格式化       | `style(css): fix button alignment`           |
| `refactor`  | 重構代碼，不新增功能或修復問題            | `refactor(order): simplify order creation logic` |
| `test`      | 新增或修改測試                            | `test(auth): add unit tests for login`       |
| `chore`     | 工具或設定相關的更改，例如更新依賴        | `chore(deps): upgrade lodash to v4.17.21`    |
| `perf`      | 性能優化                                  | `perf(api): improve response time for search` |
| `hotfix`    | 緊急修復生產環境的重大問題                | `hotfix(ui): fix checkout crash in production` |
| `build`     | 構建系統或外部依賴相關更改                | `build: update webpack configuration`        |
| `ci`        | 修改 CI/CD 配置或腳本                    | `ci(actions): update deployment workflow`    |
| `revert`    | 撤銷之前的提交                            | `revert: revert "fix: update login logic"`   |

---

### Commit Message 格式範例

## 環境要求
- Windows、Mac、Linux 系統電腦
- Google Chrome、Firefox、Safari等瀏覽器
