unit FrmFahrzeug;

interface

uses
  Vcl.Forms, Vcl.StdCtrls, Vcl.Controls, MobiqStamm;

type
  TFrmFahrzeug = class(TForm)
    edtKennzeichen: TEdit;
    edtZuladung: TEdit;
    cbxFiliale: TComboBox;
  end;

implementation

{$R *.dfm}

end.
