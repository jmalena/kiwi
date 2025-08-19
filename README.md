<summary>
  <h2>Kiwi</h2>
  <picture>
    <source media="(prefers-color-scheme: dark)" srcset="https://github.com/user-attachments/assets/33269229-6fc0-4159-bb1a-3362ee444acb">
    <source media="(prefers-color-scheme: light)" srcset="https://github.com/user-attachments/assets/2057a977-2f40-455d-8471-08e25246409a">
    <img align="left" height="100" alt="Logo" src="https://github.com/user-attachments/assets/2057a977-2f40-455d-8471-08e25246409a">
  </picture>
  <br />
  Kiwi is a simple, Lisp-like language and interpreter created for educational purposes.
</summary>

<br />

## Usage

To start the Kiwi REPL (interactive prompt):

```bash
java -jar dist/kiwi-0.1.0.jar
```

To run a Kiwi program from a file:

```bash
java -jar dist/kiwi-0.1.0.jar path/to/file.kiwi
```

To display available command-line options:

```bash
java -jar dist/kiwi-0.1.0.jar --help
```

## Documentation

- [Documentation (English)](docs/en/index.md)

## Building From Source

Run tests to verify that the interpreter will work correctly on your system.

```bash
make test
```

Then build Kiwi interpreter using:

```bash
make build
```

This produces the Kiwi interpreter executable, located at `dist/kiwi-0.1.0.jar`.

## Contributing

Contributions, ideas, and bug reports are welcome! Feel free to open issues or submit pull requests.

## License

Kiwi language and interpreter are licensed under the MIT License.
