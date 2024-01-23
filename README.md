

<body><a href="https://drive.google.com/file/d/10qhGjn7biURykP8hIcT6NJHoGX-WOHUh/view">Task</a>

<table>
  <tr><th>Версия Java</th><th>Система сборки</th><th>Версия сборки</th><th>Библиотеки</th><th>Кодировка</th></tr>
  <tr><td>20.0.2</td><td>Maven</td><td>10</td><td>junit - 4.12</td><td>UTF-8</td></tr>
</table>

<div>junit</div>
<div id="your-badge-code3" style="background: #f0f0f0; overflow:auto;width:auto;border:solid gray;border-width:.1em .1em .1em .8em;padding:.2em .6em;"><pre style="margin: 0; line-height: 125%"><span style="color: #062873; font-weight: bold">&lt;dependency&gt;</span>
      <span style="color: #062873; font-weight: bold">&lt;groupId&gt;</span>junit<span style="color: #062873; font-weight: bold">&lt;/groupId&gt;</span>
      <span style="color: #062873; font-weight: bold">&lt;artifactId&gt;</span>junit<span style="color: #062873; font-weight: bold">&lt;/artifactId&gt;</span>
      <span style="color: #062873; font-weight: bold">&lt;version&gt;</span>4.12<span style="color: #062873; font-weight: bold">&lt;/version&gt;</span>
      <span style="color: #062873; font-weight: bold">&lt;scope&gt;</span>test<span style="color: #062873; font-weight: bold">&lt;/scope&gt;</span>
<span style="color: #062873; font-weight: bold">&lt;/dependency&gt;</span>
</div>

<div>
  <button class="btn-copy" data-clipboard-target="#your-badge-code1">Запуск</button>
</div>
<pre><code id="your-badge-code1">java -jar target/filter-1.0-SNAPSHOT.jar </code></pre>
</div><body>

<div>
  <button class="btn-copy" data-clipboard-target="#your-badge-code1">Пример запуска</button>
</div>
<pre><code id="your-badge-code1">java -jar target/filter-1.0-SNAPSHOT.jar -f -p "sapmle-" -o "files/file" "files/in1.txt" "files/in2.txt"</code></pre>
</div><body>

<div>
  <button class="btn-copy" data-clipboard-target="#your-badge-code2">Сборка</button>
</div>
<pre><code id="your-badge-code2">mvn clean install</code></pre>
</div>

<table>
  <tr><th>Параметр</th><th>Аргумент</th><th>Значение</th>
  <tr><td>-f</td><td>-</td><td>Полная статистика</td>
  <tr><td>-s</td><td>-</td><td>Краткая статистика</td>
  <tr><td>-a</td><td>-</td><td>Добавление, а не перезаписывание</td>
  <tr><td>-o</td><td>String</td><td>Путь для сохранения файлов</td>
 <tr><td>-p</td><td>String</td><td>Начальное название всех файлов</td>
</table>

</body>




