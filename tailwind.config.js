/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./*.html",         // Para arquivos HTML na raiz do seu projeto
    "./**/*.html",      // Para arquivos HTML em subpastas
    "./src/**/*.{js,jsx,ts,tsx}", // Se você tiver arquivos JS/JSX em uma pasta 'src'
    // Adicione outros caminhos conforme a estrutura do seu projeto
  ],
  theme: {
    extend: {
      // Aqui você pode estender ou sobrescrever as configurações padrão do Tailwind
      // Por exemplo, adicionar cores personalizadas:
      // colors: {
      //   'minha-cor-primaria': '#1a2b3c',
      //   'minha-cor-secundaria': '#d1e2f3',
      // },
    },
  },
  plugins: [],
}