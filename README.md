# 問題

- 後述の仕様を満たしながらユーザーのメールアドレスを変更する処理のテストコードの実装とリファクタリングをしてください。
- 後述の仕様は未実装のものがあります。ソースコードを読み仕様の通り実装してください。
- リファクタリング指針として、業務上のロジックと外部のシステム（データベースやメールサービス）に対しての処理を分離することを考えてください。
- リファクタリングの際に新しくクラスやメソッドが追加される場合、それはどんなものか、なぜそれを追加したのかをコードコメントに簡潔に記載してください。
- 書き足したテストケースは全てパスするように実装してください。
- 下記の仕様以上の実装はする必要はありません。厳密にはメールアドレスは空文字を許容しなかったり、一定の形式に沿って定義する必要がありますが、今回はそのような実装をする必要はありません。その他の常識的に考えて実装すべき仕様についても同様に今回は実装する必要はありません。

# 仕様

- もしユーザのメールアドレスに自社のドメイン名が含まれている場合、そのユーザの種類（userType）を従業員（EMPLOYEE）として登録し、そうでない場合は顧客（CUSTOMER）として登録する。
- 登録されたユーザの中から従業員となるユーザーの数（numberOfEmployees）を管理し、もし、ユーザの種類が従業員から顧客に変わるのであれば、従業員数を減らし、その逆に顧客から従業員に変わるのであれば、従業員数を増やすようにする。
- メールアドレスの変更ができたら、メールサービス（Mailer）にメッセージを送り、メールアドレスが変更されたことを外部のシステムに通知する。
- 現在のメールアドレスが認証されているメールアドレス（isEmailConfirmed）のみ変更可能。
- 変更後のメールアドレスは未認証のものとして保存する。

# 制約

- Database.ktはRDBMS相当のものとみなして扱うこと（MySQLなどのイメージ）。
- Database.ktの実装は変更しないこと。ただしファイルの移動は可能。
- Mailer.ktは外部のメールサービスにメッセージを送るものとして扱うこと（SendGridなどのイメージ）。処理を呼び出すと実際に外部のメールサービスを呼びだしメッセージが送られてしまう。
- Mailer.ktの実装は変更しないこと。ただしファイルの移動は可能。
- パッケージ、レイヤーなどは自由に定義してよい。クラス、メソッドも自由に追加して良い。
- テスティングライブラリ含め必要ならば自由なものをインポートして使って良い。テストケースは日本語でも英語でも良い。

# 環境構築

```
// OpenJDK 11をダウンロード（Macの場合）
brew tap homebrew/cask-versions
brew install --cask temurin11

// Main.ktを実行（Main.ktは評価対象ではありません）
./gradlew run

// テストを実行
./gradlew test
```

# 評価項目
下記の項目を上から優先して評価します。

- コードリーディング
    - 既存のコードを読み解き、未実装の仕様を実装することができるか。
- テストコード
    - 仕様からテストケースを抜き出し、レイヤーごとのテストのメリットデメリットを考慮しながら適切な箇所に適切な量のテストコードを作成することができるか。その意思決定を説明できるか。
    - Database.ktやMailer.ktのような外部のシステムをテストコード上でどう取り扱うか定義し、テストコードの保守性、実行スピードに気を配りながら実装できるか。その意思決定を説明できるか。
    - テストケースを見ただけで、テスト対象のコードの仕様が理解できるか。
- モデリング・リファクタリング
    - 仕様において重要なロジックを定義し、それらを適切なモデルとしてまとめることができるか。
    - なぜその責務を持つクラスにしたのかを説明することはできるか。


# 提出方法

- プロジェクト全体をzipにまとめて、メールに添付して送信してください。
    - .gradle, .idea, build, .git などのディレクトリ配下のファイルは提出不要です。
- 問題内容は社外に公開することは禁止です。公開されたGitHubリポジトリにプッシュするなどの行為はしないでください。
