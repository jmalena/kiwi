# Kiwi

**Kiwi** is a simple, Lisp-like language and interpreter created for educational purposes.

![Kiwi Logo](logo.jpg)

---

## Usage

To start the Kiwi REPL (interactive prompt):

```bash
java -jar dist/kiwi.jar
```

To run a Kiwi program from a file:

```bash
java -jar dist/kiwi.jar path/to/file.kiwi
```

To display available command-line options:

```bash
java -jar dist/Kiwi.jar --help
```

## Documentation

- 📘 [Documentation (English)](docs/en/index.md)
- 📙 [Dokumentace (Česky)](docs/cs/index.md)


## Building From Source

To build Kiwi from source:

```bash
mkdir -p dist
javac -d dist $(find src -name "*.java")
jar cfm dist/kiwi.jar manifest.mf -C dist .
```

## Contributing

Contributions, ideas, and bug reports are welcome! Feel free to open issues or submit pull requests.


## License

Kiwi is licensed under the MIT License.
